class Pessoa:
    def __init__(self, nome, idade, altura):
        self.nome = nome
        self.idade = idade
        self.altura = altura

    def exibir_informacoes(self):
        print(f"Nome: {self.nome}")
        print(f"Idade: {self.idade} anos")
        print(f"Altura: {self.altura:.2f} metros")

class Funcionário(Pessoa):
    def __init__(self, nome, idade, altura, cargo, salario):
        super().__init__(nome, idade, altura)
        self.cargo = cargo
        self.salario = salario
        
    def exibir_informacoes(self):
        super().exibir_informacoes()
        print(f"Cargo: {self.cargo}\nSalário: R$ {self.salario:,.2f}")

fun1 = Funcionário("Ana", 25, 1.70, "CEO", 20000000)
fun1.exibir_informacoes()
