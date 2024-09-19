# Clock para Desktop em JavaFX
Um projeto de relógio para desktop desenvolvido em JavaFX, projetado para fins de aprendizado e prática com o biblioteca gráfica JavaFX. O aplicativo oferece duas visões de relógio: digital e analógico, com uma interface gráfica simples e interativa. O projeto utiliza o **Maven** para gerenciamento de dependências e facilitar a compilação e execução.

## Funcionalidades
- **Modo Digital**: Exibe a hora atual em formato digital.
- **Modo Analógico**: Exibe a hora atual em formato analógico com ponteiros para horas, minutos e segundos.
- **Alternância de Modos**: Permite alternar entre a visualização digital e analógica do relógio.
- **Atualização em Tempo Real**: Atualiza os ponteiros do relógio analógico e a visualização digital em tempo real.

## Instalação e Execução

Neste guia foi utilizado a IDE **Intellij** no sistema operacional Windows.

1. **Clonando o Repositório**

```bash
git clone https://github.com/jmsmarcelo/clock-desktop-javafx.git
```

2. **Abrindo o Projeto com o Intellij**

    No Intellij  vá em Menu > File > Open, e seleciona a pasta do Projeto que foi clonado.

3. **Compilando o Projeto**

    Mostrarei duas maneiras de compilar o Projeto.

    1. **Compilando com o Jlink**
   
        Jlink é uma ferramente que permite criar uma imagem de tempo de execução personalizada contendo apenas os módulos Java necessários para a sua aplicação. A desvantagem é que somente é possível utilizar no tipo de sistema em que foi compilado.
      
        Com o Projeto aberto no Intellij:

            Maven > clock-desktop-javafx > Plugins > javafx > javafx:jlink

       ![Screenshot 2024-09-18 000452](https://github.com/user-attachments/assets/ac55f7b8-5082-45f9-83f2-026e6b498d4c)

       Isso irá gerar uma pasta contendo um executável `.bat` ou `.sh` dependendo do sistema operacional.

    3. **Compilando com o Jar**

        O arquivo `.jar` é um formato de arquivo compactado que contém todos os recursos necessários para executar uma aplicação Java. No entanto, para executar um arquivo `.jar` de JavaFX, você precisará baixar o SDK do JavaFX

        Com o Projeto aberto no Intellij:
        
            Maven > clock-desktop-javafx > Plugins > jar > jar:jar

       ![Screenshot 2024-09-18 000515](https://github.com/user-attachments/assets/1b9b7034-e1e3-4b5a-8aac-7f13e5b5cd8e)

4. **Executando o arquivo compilado**

    Cada tipo de compilação têm maneiras diferentes de serem executadas

    1. **Arquivo compilado com o Jlink**

        É gerado uma pasta, basta apenas dá um click duplo no arquivo `app.bat`

            [pastaDoProjeto] > target > app > app.bat
    
    2. **Arquivo .Jar**

        Para executar o arquivo jar de JavaFX é necessário primeiro fazer o [download do JavaFX](https://gluonhq.com/products/javafx/).

        Após o download e descompactação, execute os seguintes comandos no CMD na pasta do projeto (substitua `caminho\completo\da\pasta\JavaFX\lib` pelo caminho completo da pasta `lib` do JavaFX):
        ```cmd
        java --module-path caminho\completo\da\pasta\JavaFX\lib --add-modules javafx.controls,javafx.fxml -jar target\clock-desktop-javafx-1.0-SNAPSHOT.jar
        ```

## Capturas de Tela

### Relógio Analógico

![Screenshot 2024-09-18 213911](https://github.com/user-attachments/assets/31b9eabd-b14f-4042-b867-5519ed9e72fb)

### Relógio Digital
![Screenshot 2024-09-18 213924](https://github.com/user-attachments/assets/4de5773e-90e7-430e-8851-298a7c6cf7d3)

## Requisitos

- Java 21 ou superior
- JavaFX 21
- Maven

## Licença

Este projeto está licenciado sob a [MIT License](https://github.com/jmsmarcelo/clock-desktop-javafx/blob/main/LICENSE).

