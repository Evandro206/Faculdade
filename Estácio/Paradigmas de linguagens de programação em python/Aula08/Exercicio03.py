class Circulo:
    # Atributo de classe para contar o total de círculos
    __total_circulos = 0
    
    def __init__(self, raio):
        self.raio = raio
        # Incrementa o contado sempre que um novo círculo é criado
        Circulo.__total_circulos += 1
    
    @classmethod
    def total_circulos(cls):
        return cls.__total_circulos

# Criando instâncias de Círculo
c1 = Circulo(5)
c3 = Circulo(7)
c2 = Circulo(3)

# Acessando o contador de círculos
print(f'Total de círculos criados: {Circulo.total_circulos()}')