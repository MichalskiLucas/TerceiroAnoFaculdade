document.addEventListener("DOMContentLoaded", function() {
    const receitaCard = document.getElementById("receitaCard");
    const despesaCard = document.getElementById("despesaCard");
    const liquidoCard = document.getElementById("liquidoCard");

    // Função para ajustar a cor com base no valor
    function adjustColor(card, value) {
        const redValue = Math.abs(value / 500); // Valor absoluto para o tom de vermelho
        const greenValue = 1 - Math.abs(value / 500); // Valor inverso para o tom de verde
        const blueValue = 0; // Tom fixo de azul

        const backgroundColor = `rgb(${255 * redValue}, ${255 * greenValue}, ${255 * blueValue})`;
        card.style.backgroundColor = backgroundColor;

        // Atualiza o valor exibido no card
        card.querySelector('.card-body').textContent = `$${value}`;
    }

    // Função para alterar os valores
    function changeValues() {
        const receitaValue = Math.floor(Math.random() * 1000); // Altera para um valor aleatório entre 0 e 1000
        const despesaValue = Math.floor(Math.random() * 1000);
        const liquidoValue = Math.floor(Math.random() * 1000);

        console.log("Novos valores:");
        console.log("Receita:", receitaValue);
        console.log("Despesa:", despesaValue);
        console.log("Líquido:", liquidoValue);

        adjustColor(receitaCard, receitaValue);
        adjustColor(despesaCard, despesaValue);
        adjustColor(liquidoCard, liquidoValue);
    }

    // Atualização inicial dos valores
    changeValues();

    // Adicionando evento de clique ao botão
    const changeValuesButton = document.getElementById("changeValuesButton");
    changeValuesButton.addEventListener("click", changeValues);
});
