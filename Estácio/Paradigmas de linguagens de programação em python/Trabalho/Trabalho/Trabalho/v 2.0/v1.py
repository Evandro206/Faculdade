import datetime

numerocliente = 1
numeroconta = 1

class Cliente:
    def __init__(self,numero,cpf,nome,data):
        self.numero = numero
        self.cpf = cpf
        self.nome = nome
        self.data = data
        
    @staticmethod
    def criarcliente():
        global numerocliente
        nome = input("Digite seu nome completo").lower
        while True:
            try:
                data = input("Digite sua data de nascimento da seguinte maneira (dd/mm/yyyy): ")
                print(data)
                datavalida = datetime.strptime(data, "%d/%m/%Y")
                print(f"Data válida: {datavalida}")
                break
            except:
                print("A data foi digitada de maneira incorreta, ou apresenta caracteres invalidos.\n Tente novamente!")
        while True:
            cpf = input("Digite seu CPF sem espaços nem pontos ou traços: ")
            if len(cpf) != 11:
                true = False
            else:            
                soma = sum(int(cpf[i]) * (10 - i) for i in range(9))
                primeiro_digito = (soma * 10 % 11) % 10
                soma = sum(int(cpf[i]) * (11 - i) for i in range(10))
                segundo_digito = (soma * 10 % 11) % 10
                true = cpf[-2:] == f"{primeiro_digito}{segundo_digito}"
            if true == False:
                print("CPF invalido ou digitado de forma incorreta")
            else:
                break
        clientedef = Cliente
        clientedef = (numerocliente,cpf,nome,datavalida)
        print("Vamos criar uma conta inicial:")
        Conta.criaconta(clientedef)
        ######################
        numerocliente = numerocliente + 1
        return clientedef
        

                
class Conta:
    def __init__(self, numero, cliente, tipo, saldo=0):
        self.numero = numero
        self.cliente = cliente
        self.tipo = tipo
        self.saldo = saldo
    @staticmethod
    def criaconta(clientedef):
        tipo_de_conta = ['corrente','poupanca']
        while True:
            tipo = input("Digite o tipo de conta que deseja (corrente/poupanca):").lower
            if tipo in tipo_de_conta:
                break
            else:
                print("Tipo de conta digitado incorretamente, tente novamente")
        if tipo == 'corrente':     
            data = datetime.now()         
            idade = data.year - clientedef.data.year
            conta = ContaCorrente(clientedef.numero, clientedef, idade)
        else:
            conta = ContaPoupanca(clientedef.numero, clientedef)
        
        return conta
        
        
class ContaCorrente(Conta):
    def __init__(self, numero, cliente, idade, saldo=0):
        super().__init__(numero, cliente, 'corrente', saldo)
        self.limite_cheque_especial = idade * 50

    def sacar(self, valor):
        if valor > self.saldo + self.limite_cheque_especial:
            print("Saldo insuficiente, incluindo cheque especial.")
        else:
            self.saldo -= valor
            print(f"Saque de {valor} realizado com sucesso. Saldo atual: {self.saldo}")

class ContaPoupanca(Conta):
    def __init__(self, numero, cliente, saldo=0, taxa_juros=0.01):
        super().__init__(numero, cliente, 'poupanca', saldo)
        self.taxa_juros = taxa_juros

    def calcular_juros(self):
        juros = self.saldo * self.taxa_juros
        self.saldo += juros
        print(f"Juros de {juros} aplicados. Saldo atual: {self.saldo}")
    
    def sacar(self, valor):
        if valor > self.saldo:
            print("Saldo insuficiente.")
        else:
            self.saldo -= valor
            print(f"Saque de {valor} realizado com sucesso. Saldo atual: {self.saldo}")

def inicio():
    print('+++++++++#######+++++++++')
    print('+++++++ BEM VINDO +++++++')
    print('++++++++++ AO +++++++++++')
    print('+++++++++ BANCO +++++++++')
    print('+++++++++#######+++++++++')
while True:
    inicio()
    try: #Função: While responsável para repetir a execução do código até que o programa se encerre.
        oqueFazer = int(input('\nO que você deseja fazer? \n1- Criar cliente\n2- Criar conta_ Imcompleto\n3- Excluir cliente_ Imcompleto\n4- Excluir conta _ Imcompleto\n5- Exibir cliente_ Imcompleto\n6- Exibir conta _ Imcompleto\n7- Encerrar aplicação\n'))
        if oqueFazer == 1: #Função: Criar um objeto da classe Cliente.
            Cliente.criarcliente()
        elif oqueFazer == 2: #busca o cliente e cria a conta
            Conta.criaconta()
    except ValueError:
        print('Por favor, insira um número válido.')     