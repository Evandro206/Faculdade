class Pessoa:
    def __init__(self, nome):
            self.__nome = nome
    
    @property
    def nome(self):
        return self.__nome
    
    @nome.setter
    def nome(self, nome):
        if isinstance(nome, str):
            self.__nome = nome
        else:
            raise ValueError('Nome deve ser uma string!')
        
p = Pessoa('Alice')
print(p.nome) 

p.nome = 'Bob'
print(p.nome)
