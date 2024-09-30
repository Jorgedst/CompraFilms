import pandas as pd
import matplotlib.pyplot as plt

# Leemos el archivo
file_path = '/content/compras.txt'
data = pd.read_csv(file_path, sep=',', header=None, names=['id_compra', 'id_cliente', 'id_pelicula', 'fecha'])

data['fecha'] = pd.to_datetime(data['fecha'])


#Ventas en un intervalo de tiempo
fecha_inicio = '2024-1-01'  # Ajustamos el intervalo
fecha_fin = '2024-12-20'
ventas_intervalo = data[(data['fecha'] >= fecha_inicio) & (data['fecha'] <= fecha_fin)]
ventas_intervalo_por_dia = ventas_intervalo.groupby('fecha').size()
plt.figure(figsize=(10, 6))
ventas_intervalo_por_dia.plot(kind='line', marker='.', color='darkgreen')
plt.title('Ventas')
plt.xlabel('Fecha')
plt.ylabel('Número de Ventas')
plt.grid(True)
plt.show()
