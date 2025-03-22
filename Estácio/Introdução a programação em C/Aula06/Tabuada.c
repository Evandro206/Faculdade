#include <stdio.h>

int main(void) {
  int multiplicador, multiplicado, resultado;
  printf("Escolha um número para a tabuada:\n");
  scanf("%d", &multiplicado);

  multiplicador = 0;

  do {
    resultado = multiplicado * multiplicador;
    printf("%d x %d = %d\n", multiplicado, multiplicador, resultado);
    multiplicador = multiplicador + 1;
  } while (multiplicador <= 10);
  return 0;
}