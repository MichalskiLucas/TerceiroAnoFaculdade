function voltar(){
    history.back();
}

function mostrarHint(campoId, mostrar) {
    var hintElement = document.getElementById('hint' + campoId.charAt(0).toUpperCase() + campoId.slice(1));

    if (mostrar) {
        hintElement.style.display = 'block';
    } else {
        hintElement.style.display = 'none';
    }
}

function validarCadastro() {
    var nome = document.getElementsByName("nome")[0].value;
    var email = document.getElementsByName("email")[0].value;
    var senha = document.getElementsByName("senha")[0].value;

    if (nome === '') {
        mostrarHint('Nome', true);
        return false; // Impede o envio do formulário
    } else {
        mostrarHint('Nome', false);
    }

    if (email === '') {
        mostrarHint('Email', true);
        return false; // Impede o envio do formulário
    } else {
        mostrarHint('Email', false);
    }

    if (senha === '') {
        mostrarHint('Senha', true);
        return false; // Impede o envio do formulário
    } else {
        mostrarHint('Senha', false);
    }

    return true; // Permite o envio do formulário
}