#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int i, j, k, l, m = 0;
  do {
    i = rand() % 100;
    i = i + 1;
    l = 0;
    j = 0;
    do {
      printf("Digite um numero e tente acertar:\n");
      scanf("%d", &k);
      if (k == i) {
        printf("Voce acertou\n");
        l++;
      } else {
        printf("Voce errou\n");
        if (k < i){
            printf("O numero Digitado e menor que o numero correto.\n");
        } else {
            printf("O numero Digitado e maior que o numero correto.\n");
        }
      }
      j++;
    } while (j < 10 && l == 0);
    if (l < 1) {
      printf("Acabaram as tentativas:\n");
    }
    printf("Quer jogar novamente? 1 para sim e 2 para nao:\n");
    scanf("%d", &m);
  } while(m == 1);
  printf("Fim do Jogo!!!");
  return 0;
}
