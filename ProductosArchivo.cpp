#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main() {
    ifstream archivo("productos.txt");
    string nombre, productoMayor;
    double precio, precioMayor = -1;
    int cantidad;
    double totalGeneral = 0;

    if (!archivo.is_open()) {
        cout << "Error: No se pudo abrir productos.txt" << endl;
        return 1;
    }

    cout << "--- DETALLE DE PRODUCTOS ---" << endl;
    while (archivo >> nombre >> precio >> cantidad) {
        double subtotal = precio * cantidad;
        totalGeneral += subtotal;

        if (precio > precioMayor) {
            precioMayor = precio;
            productoMayor = nombre;
        }

        cout << "Producto: " << nombre << " | Subtotal: $" << subtotal << endl;
    }

    cout << "----------------------------" << endl;
    cout << "Total de la compra: $" << totalGeneral << endl;
    cout << "Producto mas caro (unitario): " << productoMayor << " ($" << precioMayor << ")" << endl;

    archivo.close();
    return 0;
}
