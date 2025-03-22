from abc import ABC, abstractmethod

# Definição de classe abstrata
class Forma(ABC):
    
    @abstractmethod
    def area(self):
        pass
    
    @abstractmethod
    def perimetro(self):
        pass
    
# Tentando instanciar uma classe abstrata diretamente daria erro
# f = forma() # Isso resltaria em um erro porque não se pode instanciar uma classe abstrata

# Subclasse que herda de forma e implementa os métodos abstratos
class Retangulo(Forma):
    def __init__(self, largura, altura):
        self.largura = largura
        self.altura = altura
        
    # Implementação do método abstrato "área"
    def area(self):
        return self.altura * self.largura
    
    # Implementação do método abstrato "perimetro"
    def perimetro(self):
        return 2 * (self.altura + self.largura)
    
# Criando uma instância de classe retangulo
retangulo = Retangulo(5, 3)

print(f'Área: {retangulo.area()}')
print(f'Perimetro: {retangulo.perimetro()}')