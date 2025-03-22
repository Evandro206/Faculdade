#include <stdio.h>

int main(void) {
  float corrida, distancia, custo, valor_km_verde, valor_km_vermelho, bandeira;
  
  valor_km_verde = 0.5;
  valor_km_vermelho = 1;

    printf("Qual o valor da taxa de corrida? ");
    scanf("%f", &corrida);
    printf("Quantos kms percorridos? ");
    scanf("%f", &distancia);
    printf("Digite 1-VERDE ou 2-VERMELHA? ");
    scanf("%f", &bandeira);
  
    if (bandeira == 1) {

    printf("Qual o valor do km verde? ");
    scanf("%f", &valor_km_verde);

    custo = corrida + (distancia * valor_km_verde);
    printf("O custo da corrida foi de: %.2f\n", custo);
    }
    else 
     if (bandeira == 2 ){

      printf("Qual o valor do km vermelho? ");
      scanf("%f", &valor_km_vermelho); 
    
      custo = corrida + (distancia * valor_km_vermelho);
      printf("O custo da corrida foi de: %.2f\n", custo);
    }
     else {
     printf("Digite um valor válido!");
  }
  return 0;
} 