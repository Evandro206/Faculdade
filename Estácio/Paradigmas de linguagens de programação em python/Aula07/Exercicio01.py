class Pessoa:
    def __init__(self, nome, idade, altura):
        self.nome = nome
        self.idade = idade
        self.altura = altura
        self.saudacao()
        
    def exibir_informacoes(self):
        print(f"Nome: {self.nome}")
        print(f"Idade: {self.idade} anos")
        print(f"Altura: {self.altura:.2f} metros")
    
    def saudacao(self):
        print("Ola!")
    
pessoa1 = Pessoa("Ana", 35, 1.7)
pessoa1.exibir_informacoes()
pessoa1.saudacao()

pessoa2 = Pessoa("Evandro", 18, 1.85)
pessoa2.exibir_informacoes()