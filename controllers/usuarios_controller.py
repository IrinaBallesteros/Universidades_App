# controllers/usuarios_controller.py
from flask import Blueprint, request, jsonify
from config.db import usuarios

usuarios_bp = Blueprint('usuarios', __name__)

@usuarios_bp.route("/api/usuarios", methods=["POST"])
def crear_usuario():
    data = request.get_json()
    usuario = {
        "username": data.get("username"),
        "password": data.get("password"),
        "nombre": data.get("nombre"),
        "email": data.get("email")
    }
    if usuarios.find_one({"username": usuario["username"]}):
        return jsonify({"mensaje": "Usuario ya existe"}), 409
    usuarios.insert_one(usuario)
    return jsonify({"mensaje": "Usuario creado correctamente"}), 201

@usuarios_bp.route("/api/login", methods=["POST"])
def login_usuario():
    data = request.get_json()

    username = data.get("username")
    password = data.get("password")

    if not username or not password:
        return jsonify({"mensaje": "Faltan datos"}), 400

    user = usuarios.find_one({"username": username, "password": password})
    
    if user:
        return jsonify({"mensaje": "Login exitoso"}), 200
    else:
        return jsonify({"mensaje": "Credenciales inválidas"}), 401


@usuarios_bp.route("/api/recuperar", methods=["POST"])
def recuperar_clave():
    data = request.get_json()
    user = usuarios.find_one({"email": data.get("email")})
    if user:
        return jsonify({"clave": user["password"]}), 200
    return jsonify({"mensaje": "Correo no registrado"}), 404
