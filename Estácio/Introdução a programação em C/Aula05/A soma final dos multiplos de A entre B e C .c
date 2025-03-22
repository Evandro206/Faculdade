#include <stdbool.h>
#include <stdio.h>

int main(void) {

  int a, b, c, i, soma;
  bool A, B;

  A = false;
  B = false;
  do {
    do {
      printf("Digite 3 Numeros inteiros sendo A maior que 1 e C > B:\n");
      printf("A: ");
      scanf("%d", &a);
      printf("B: ");
      scanf("%d", &b);
      printf("C: ");
      scanf("%d", &c);
      if (a > 1) {
        A = true;
      } else {
        (printf("A deve ser maior que 1\n"));
      }
    } while (A != true);
    if (c > b) {
      B = true;
    } else {
      printf("C deve ser maior que B, digite novamente os valores de A e C\n"	); 
    }
  } while (B != true);
  i = b;
  soma = 0;
   do{
    if (i % a == 0){
      soma = soma + i;
      printf("O numeor a ser somado é %d\n", i);
      printf("A soma atual é %d\n", soma);
    }
     i++;
   } while (i >= b && i <= c);
  printf("A soma final dos multiplos de %d entre %d e %d é %d\n", a, b, c, soma);
}
