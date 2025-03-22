#include <stdio.h>
#include <stdbool.h>

int main(void) {
  float nota1, nota2, notamaxima, media, limite =0.75;
  int numerodefaltas, numerodeaulas, I, tentativas = 4;
  float frequencia, frequenciaminima;
  bool aprovado;
  I = 1;
  while (I <= tentativas){
    printf("Tentativa número %d\n""=========================\n", I); 
    printf("Qual a nota máxima:\n");
     scanf("%f", &notamaxima);
    printf("Qual a primeira nota:\n");
      scanf("%f", &nota1);
    printf("Qual a segunda nota:\n");
      scanf("%f", &nota2);
        media = (nota1 + nota2) / 2;
  if (media < notamaxima * 0.6){
    aprovado = true;
  } else {
    aprovado = false;
  }
    printf("Qual o número de aulas?\n");
       scanf("%d", &numerodeaulas);
    printf("Qual o número de faltas?\n");
       scanf("%d", &numerodefaltas);
        frequencia = (float) numerodefaltas / numerodeaulas;
        frequenciaminima = numerodeaulas * limite;
  if (frequencia < frequenciaminima ){
    aprovado = true;
  } else {
    aprovado = false;
  }
  printf("Média: %.2f\n", media);
  printf("Frequência: %.2f %%\n", (100 - (frequencia * 100)));
  if (aprovado == true){
    printf("Aprovado\n");
  } else {
    printf("Reprovado\n");
  }
    I = I + 1;
  }
  return 0;
}