# controllers/universidades_controller.py
from flask import Blueprint, request, jsonify
from config.db import universidades

universidades_bp = Blueprint('universidades', __name__)

@universidades_bp.route("/api/universidades", methods=["POST"])
def crear_universidad():
    data = request.get_json()
    universidades.insert_one(data)
    return jsonify({"mensaje": "Universidad guardada correctamente"}), 201

@universidades_bp.route("/api/universidades", methods=["GET"])
def listar_universidades():
    docs = list(universidades.find({}, {"_id": 0}))
    return jsonify(docs), 200
