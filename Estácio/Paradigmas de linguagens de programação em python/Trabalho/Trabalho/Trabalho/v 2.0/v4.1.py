from datetime import datetime

numerocliente = 1
numeroconta = 1
clientes = []
contas = []

class Cliente:
    def __init__(self, numero, cpf, nome, data):
        self.numero = numero
        self.cpf = cpf
        self.nome = nome
        self.data = data

    def __str__(self):
        return f"Cliente(nome={self.nome}, cliente={self.numero}, cpf={self.cpf}, data de nascimento={self.data})"

    def excluicliente(self):
        self.numero = None
        self.cpf = None
        self.nome = None
        self.data = None
        print("Cliente excluido com sucesso !")
        return
    @staticmethod
    def exibircliente(a):
        print("O nome do(a) cliente é:",a.nome)
        print("O numero do(a) cliente é:",a.numero)
        print("A data de nascimento do(a) cliente é:",a.data)
        return

    @staticmethod
    def criarcliente():
        global numerocliente
        global clientes

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
                print("CPF invalido ou digitado de forma incorreta!")
            else:
                break
        Cliente.findcliente(cpf)
        while True:
            try:
                data = input("Digite sua data de nascimento da seguinte maneira (dd/mm/yyyy): ")
                datavalida = datetime.strptime(data, "%d/%m/%Y")
                break
            except:
                print("A data foi digitada de maneira incorreta, ou apresenta caracteres invalidos.\n Tente novamente!")
        nome = input("Digite seu nome completo: ").lower()

        clientedef = Cliente(numerocliente, cpf, nome, datavalida)
        print("Vamos criar uma conta inicial: ")
        clientes.append(clientedef)
        Conta.criaconta(clientedef)
        numerocliente = numerocliente + 1

        return clientedef

    @staticmethod
    def findcliente(procurado):
        for i, cliente in enumerate(clientes):
            if procurado == cliente.cpf:
                return i
        return "a"



class Conta:
    def __init__(self, numero, cliente, tipo, saldo=0):
        self.numero = numero
        self.cliente = cliente
        self.tipo = tipo
        self.saldo = saldo

    def __str__(self):
        return f"Conta(numero={self.numero}, cliente={self.cliente}, tipo={self.tipo}, saldo={self.saldo})"

    @staticmethod
    def criaconta(clientedef):
        global numeroconta
        global contas
        tipo_de_conta = ["corrente", "poupanca"]
        while True:
            tipo = input("Digite o tipo de conta que deseja (corrente/poupanca):").lower()
            if tipo in tipo_de_conta:
                break
            else:
                print(tipo, 'erro')
                print("Tipo de conta digitado incorretamente, tente novamente")
        if tipo == 'corrente':
            data = datetime.now()
            if (data.month, data.day) < (clientedef.data.month, clientedef.data.day):
                aniversario = 1
            else:
                aniversario = 0
            idade = data.year - clientedef.data.year - aniversario
            conta = ContaCorrente(tipo, numeroconta, clientedef.numero, idade)
        else:
            conta = ContaPoupanca(tipo, numeroconta, clientedef.numero)
        contas.append(conta)
        numeroconta += 1
        return

    @staticmethod
    def findconta(procurado):
        for i, contax in enumerate(contas):
            if procurado == contax.numero:
                return i
        return -1

class ContaCorrente(Conta):
    def __init__(self, tipo, numero, cliente, idade, saldo=0):
        super().__init__(numero, cliente, tipo, saldo)
        self.limite_cheque_especial = idade * 50

    def sacar(self, valor):
        if valor > self.saldo + self.limite_cheque_especial:
            print("Saldo insuficiente, incluindo cheque especial.")
        else:
            self.saldo -= valor
            print(f"Saque de {valor} realizado com sucesso. Saldo atual: {self.saldo}")

class ContaPoupanca(Conta):
    def __init__(self, tipo, numero, cliente, saldo=0, taxa_juros=0.01):
        super().__init__(numero, cliente, tipo, saldo)
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

def encontra():
    while True:
        procura = input("Digite o cpf do cliente vinculado a conta: ")
        i = Cliente.findcliente(procura)
        if i == "a":
            a = input("cliente não encontrado, deseja tentar novamente? 1 - sim 2 - não")
            if a == "2":
                return -1
        else:
            return i

def encontraconta():
    while True:
        procura = input("Digite o número da conta: ")
        i = Conta.findconta(procura)
        if i == "a":
            a = input("Conta não encontrada, deseja tentar novamente? 1 - sim 2 - não")
            if a == "2":
                return False
        else:

            return i

while True:
    inicio()
    try:
        oqueFazer = int(input('\nO que você deseja fazer? \n1- Criar cliente\n2- Criar conta\n3- Excluir cliente\n4- Excluir conta _ Imcompleto\n5- Exibir cliente\n6- Exibir conta _ Imcompleto\n7- Encerrar aplicação\n'))
        if oqueFazer == 1:
            Cliente.criarcliente()
        elif oqueFazer == 2:
            i = encontra()
            if i == -1:
                print("Cliente não encontrado")
            else:
                Conta.criaconta(clientes[i])
        elif oqueFazer == 3:
            if i == -1:
                print("Cliente não encontrado")
            else:
                Cliente.excluicliente(clientes[i])
        elif oqueFazer == 5:
            i = encontra()
            if i == -1:
                print("Cliente não encontrado")
            else:
                Cliente.exibircliente(clientes[i])
    except ValueError:
        print('Por favor, insira um número válido.')
