#include <stdio.h>

int main(void) {
  float nota_aluno1, nota_aluno2, nota_aluno3, nota_aluno4, Media_aluno,
      nota_recuperacao;

  printf("Qual a nota 1 do aluno? ");
  scanf("%f", &nota_aluno1);
  while (nota_aluno1 > 10 || nota_aluno1 < 0) {
    printf("Nota invalida\n");
    printf("Qual a nota do aluno? ");
    scanf("%f", &nota_aluno1);
  }
  printf("Qual a nota 2 do aluno? ");
  scanf("%f", &nota_aluno2);
  while (nota_aluno2 > 10 || nota_aluno2 < 0) {
    printf("Nota invalida\n");
    printf("Qual a nota do aluno? ");
    scanf("%f", &nota_aluno2);
  }

  printf("Qual a nota 3 do aluno? ");
  scanf("%f", &nota_aluno3);
  while (nota_aluno3 > 10 || nota_aluno3 < 0) {
    printf("Nota invalida\n");
    printf("Qual a nota do aluno? ");
    scanf("%f", &nota_aluno3);
  }

  printf("Qual a nota 4 do aluno? ");
  scanf("%f", &nota_aluno4);
  while (nota_aluno4 > 10 || nota_aluno4 < 0) {
    printf("Nota invalida\n");
    printf("Qual a nota do aluno? ");
    scanf("%f", &nota_aluno4);
  }

  Media_aluno = (nota_aluno1 + nota_aluno2 + nota_aluno3 + nota_aluno4) / 4;

  if (Media_aluno >= 6) {
    printf("Aprovado!");
    printf("\nA media do aluno foi: %.2f", Media_aluno);
  } else if (Media_aluno >= 3 && Media_aluno < 6) {
    printf("Recuperacao! ");
    printf("\nQual a nota da recuperacao do aluno? ");
    scanf("%f", &nota_recuperacao);

    Media_aluno = (nota_aluno1 + nota_aluno2 + nota_aluno3 + nota_aluno4 +
                   nota_recuperacao) / 5;
    if (Media_aluno >= 7) {
      printf("Aprovado!");
      printf("\nA media do aluno foi: %.2f", Media_aluno);
    } else {
      printf("Reprovado!");
      printf("\nA media do aluno foi: %.2f", Media_aluno);
    }
  } else {
    printf("Reprovado!");
  }
}