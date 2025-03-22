import time

inicio = time.perf_counter()

for x in range(1000000):
    continue

fim = time.perf_counter()

tempo_decorrido = fim - inicio
print(f"Tempo decorrido: {tempo_decorrido:.6f} segundo")