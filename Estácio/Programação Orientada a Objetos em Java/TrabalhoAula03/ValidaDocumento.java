package TrabalhoAula03;

public class ValidaDocumento {

    // Método para diferenciar CPF e CNPJ
    public static boolean cpfCnpj(String documento) {
        if (documento == null || documento.isEmpty()) {
            return false;
        }
        // Remove todos os caracteres não numéricos
        documento = documento.replaceAll("\\D", "");
        if (documento.length() == 11) {
            return cpfValido(documento);
        } else if (documento.length() == 14) {
            return cnpjValido(documento);
        } else {
            return false;
        }
    }

    // Método para validação CPF
    public static boolean cpfValido(String cpf) {
        if (cpf == null) {
            return false;
        }
        // Remove todos os caracteres não numéricos
        cpf = cpf.replaceAll("\\D", "");
        // O CPF deve conter 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }
        // Verifica se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
        
        try {
            // Coleta o valor numérico da String 
            int[] digits = new int[11];
            for (int i = 0; i < 11; i++) {
                digits[i] = Character.getNumericValue(cpf.charAt(i));
            }
            
            // Cálculo do primeiro dígito verificador:
            // Multiplica cada um dos 9 primeiros dígitos pelos pesos decrescentes de 10 a 2
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += digits[i] * (10 - i);
            }
            int remainder = sum % 11;
            int firstVerifier = (remainder < 2) ? 0 : 11 - remainder;
            if (digits[9] != firstVerifier) {
                return false;
            }
            
            // Cálculo do segundo dígito verificador:
            // Multiplica cada um dos 10 primeiros dígitos por pesos decrescentes de 11 a 2
            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += digits[i] * (11 - i);
            }
            remainder = sum % 11;
            int secondVerifier = (remainder < 2) ? 0 : 11 - remainder;
            return digits[10] == secondVerifier;
        } catch (Exception e) {
            return false;
        }
    }

    // Método para validação CNPJ
    public static boolean cnpjValido(String cnpj) {
        if (cnpj == null) {
            return false;
        }
        // Remove todos os caracteres não numéricos
        cnpj = cnpj.replaceAll("\\D", "");
        // O CNPJ deve conter 14 dígitos
        if (cnpj.length() != 14) {
            return false;
        }
        // Verifica se todos os dígitos são iguais
        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }
        
        try {
            // Coleta o valor numérico da String 
            int[] digits = new int[14];
            for (int i = 0; i < 14; i++) {
                digits[i] = Character.getNumericValue(cnpj.charAt(i));
            }
            
            // Cálculo do primeiro dígito verificador:
            // Para os 12 primeiros dígitos, os multiplicadores são: 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2
            int sum = 0;
            int[] multipliers1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            for (int i = 0; i < 12; i++) {
                sum += digits[i] * multipliers1[i];
            }
            int remainder = sum % 11;
            int firstVerifier = (remainder < 2) ? 0 : 11 - remainder;
            if (digits[12] != firstVerifier) {
                return false;
            }
            
            // Cálculo do segundo dígito verificador:
            // Para os 13 primeiros dígitos (incluindo o primeiro verificador), os multiplicadores são: 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2
            sum = 0;
            int[] multipliers2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            for (int i = 0; i < 13; i++) {
                sum += digits[i] * multipliers2[i];
            }
            remainder = sum % 11;
            int secondVerifier = (remainder < 2) ? 0 : 11 - remainder;
            return digits[13] == secondVerifier;
        } catch (Exception e) {
            return false;
        }
    }
}