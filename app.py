from flask import Flask
from flask_cors import CORS
from dotenv import load_dotenv
import os

load_dotenv()

app = Flask(__name__)
CORS(app)

from controllers.usuarios_controller import usuarios_bp
from controllers.universidades_controller import universidades_bp

app.register_blueprint(usuarios_bp)
app.register_blueprint(universidades_bp)

if __name__ == "__main__":
    print("✅ Rutas activas:\n", app.url_map)
    app.run(debug=True, host="0.0.0.0", port=5000)

