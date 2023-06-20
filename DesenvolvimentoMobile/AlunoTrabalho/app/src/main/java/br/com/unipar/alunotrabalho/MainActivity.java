package br.com.unipar.alunotrabalho;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.unipar.alunotrabalho.Adapters.MediaAdapter;
import br.com.unipar.alunotrabalho.Adapters.NotaAdapter;
import br.com.unipar.alunotrabalho.Model.Aluno;
import br.com.unipar.alunotrabalho.Model.Bimestre;
import br.com.unipar.alunotrabalho.Utils.Globais;

public class MainActivity extends AppCompatActivity {

    private EditText edNome;
    private String[] vetorBimestre = new String[]{"","1º Bimestre","2º Bimestre","3º Bimestre","4º Bimestre"};
    private ListView lvNota;
    private Spinner spDisciplina;
    private Spinner spDisciplinaM;
    private Spinner spBimestre;
    private Spinner spAluno;
    private ArrayAdapter adapterBimestre;
    private EditText edRa;
    private EditText edNota;
    private ListView lvDisciplinaM;
    private String[] vetorDisciplina = new String[]{"", "Empreendedorismo",
                                                         "Relacoes interpessoais",
                                                         "Projeto Integrador",
                                                         "Desenvolvimento Frameworks",
                                                         "Gerencia de projetos",
                                                         "Qualidade de software",
                                                         "Mobile",
                                                         "Estagio",
                                                         "Desenvolvimento Web"};
    private String disciplinaSelecionada = "";

    private ArrayAdapter adapterDisciplina;
    private String bimestreSelecionado = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inicialize();
    }

    private void inicialize() {
        setContentView(R.layout.activity_main);

        spDisciplina = findViewById(R.id.spDisciplina);
        spBimestre = findViewById(R.id.spBimestre);
        adapterDisciplina = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetorDisciplina);
        adapterBimestre = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetorBimestre);

        spDisciplina.setAdapter(adapterDisciplina);
        spBimestre.setAdapter(adapterBimestre);

        edRa = findViewById(R.id.edRa);
        edNome = findViewById(R.id.edNome);
        edNota = findViewById(R.id.edNota);

        edRa.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                if(!focus && Globais.listaAlunos != null){
                    for (Aluno aluno : Globais.listaAlunos) {
                        System.out.println(aluno.getRa());
                        System.out.println(edRa.getText().toString());
                        if (aluno.getRa().equals(edRa.getText().toString())){
                            edNome.setText(aluno.getNome());
                        }
                    }
                }
            }
        });

        spBimestre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                bimestreSelecionado = (String) spBimestre.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spDisciplina.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                disciplinaSelecionada = (String) spDisciplina.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void adicionarAluno(View view){
        try {
            validaCadastro();
            if(Globais.listaAlunos == null)
                Globais.listaAlunos = new ArrayList<>();
            Bimestre bimestre = new Bimestre();
            Aluno alunoSelecionado = new Aluno();
            for(int i = 0; i < Globais.listaAlunos.size(); i++){
                if(edRa.getText().toString().equals(Globais.listaAlunos.get(i).getRa())){
                    alunoSelecionado = Globais.listaAlunos.get(i);
                }
            }
            Aluno aluno = new Aluno();
            if(!alunoSelecionado.getRa().equals("")){
                Globais.listaAlunos.remove(alunoSelecionado);
                aluno = alunoSelecionado;
            }else{
                aluno.setRa(edRa.getText().toString());
                aluno.setNome(edNome.getText().toString());
            }


            bimestre.setNota(Integer.parseInt(edNota.getText().toString()));
            bimestre.setDisciplina(disciplinaSelecionada);
            bimestre.setBimestre(bimestreSelecionado);
            aluno.setNotaBimestreAluno(bimestre);

            Globais.listaAlunos.add(aluno);
            Toast.makeText(MainActivity.this, "Registro efetuado com sucesso!", Toast.LENGTH_SHORT).show();
            limpaTela();
        }catch (Exception e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void limpaTela() {
        edNome.setText("");
        spBimestre.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetorBimestre));
        edNota.setText("");
        spDisciplina.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetorDisciplina));
        edRa.setText("");
    }

    private void validaCadastro() throws Exception {
        if (edRa.getText().toString().trim().equals("")){
            throw new Exception("RA do aluno inválido");
        }

        if (edNome.getText().toString().trim().equals("")) {
            throw new Exception("Nome do aluno inválido");
        }

        if (edNota.getText().toString().trim().equals("")) {
            throw new Exception("Nota do aluno inválida");
        }

        if (disciplinaSelecionada.equals("")) {
            throw new Exception("Disciplina inválida");
        }

        if (bimestreSelecionado.equals("")) {
            throw new Exception("Bimestre inválido");
        }
    }

    public void verNotas(View view) {
        setContentView(R.layout.activity_nota);
        spAluno = findViewById(R.id.spAluno);
        String[] vetAlunos = new String[1];
        vetAlunos[0] = "Selecione um aluno para filtrar";

        if(Globais.listaAlunos != null){
            vetAlunos = new String[Globais.listaAlunos.size() + 1];
            vetAlunos[0] = "Selecione um aluno para filtrar";
            int index = 0;
            for(Aluno aluno : Globais.listaAlunos){
                vetAlunos[++index] = aluno.getRa() + " - " + aluno.getNome();
            }
        }
        spAluno.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetAlunos));
        spAluno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i != 0 && Globais.listaAlunos != null ){
                    atualizaListaNotas(Globais.listaAlunos, i-1);
                } else if (i == 0) {
                    limpaListaNotas();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void limpaListaNotas() {
        lvNota = findViewById(R.id.lvNota);
        lvNota.setAdapter(new NotaAdapter(this, new ArrayList<>()));
    }

    private void atualizaListaNotas(ArrayList<Aluno> listaAlunos, int i) {
        Aluno alunoSelecionado = listaAlunos.get(i);
        String linha1 = "";
        String linha = "";
        String nota1bimestre = "";
        String nota2bimestre = "";
        String nota3bimestre = "";
        String nota4bimestre = "";
        ArrayList<String> disciplinas = new ArrayList<>();
        ArrayList<String> lista = new ArrayList<>();
        boolean fim = false;
        String materiaAtual = "";
        for(Aluno aluno : listaAlunos){
            if(aluno.getRa().equals(alunoSelecionado.getRa())){
                for(Bimestre notaBimestre : aluno.getNotasBimestre()){
                    materiaAtual = notaBimestre.getDisciplina();
                    for(String disciplina : disciplinas){
                        if(notaBimestre.getDisciplina() == disciplina){
                            fim = true;
                        }
                    }
                    if(!fim){
                        for(Bimestre notaCalculada : alunoSelecionado.getNotasBimestre()){
                            if (materiaAtual.equals(notaCalculada.getDisciplina())){
                                if(notaCalculada.getBimestre().equals("1º Bimestre")){
                                    nota1bimestre = notaCalculada.getNota().toString();
                                }else if(notaCalculada.getBimestre().equals("2º Bimestre")){
                                    nota2bimestre = notaCalculada.getNota().toString();
                                }else if(notaCalculada.getBimestre().equals("3º Bimestre")){
                                    nota3bimestre = notaCalculada.getNota().toString();
                                }else if(notaCalculada.getBimestre().equals("4º Bimestre")){
                                    nota4bimestre = notaCalculada.getNota().toString();
                                }
                            }
                        }
                        linha = "1Bim: "+nota1bimestre+" 2Bim: "+nota2bimestre + "3Bim: "+nota3bimestre+"4Bim: "+nota4bimestre;
                        int media = (Integer.parseInt(nota1bimestre) + Integer.parseInt(nota2bimestre) + Integer.parseInt(nota3bimestre) + Integer.parseInt(nota4bimestre)) / 4;
                        linha1 = "media: "+media;
                        fim = false;
                        nota1bimestre = "";
                        nota2bimestre = "";
                        nota3bimestre = "";
                        nota4bimestre = "";
                        disciplinas.add(notaBimestre.getDisciplina());
                        lista.add(linha1+"\n"+linha);
                    }
                }
            }
        }
        lvNota = findViewById(R.id.lvNota);
        lvNota.setAdapter(new NotaAdapter(this, lista));
    }

    @SuppressLint("MissingInflatedId")
    public void verMedias(View view){
        setContentView(R.layout.activity_media);

        spDisciplinaM = findViewById(R.id.spDisciplina);
        spDisciplinaM.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetorDisciplina));
        spDisciplinaM.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i != 0 && Globais.listaAlunos != null ){
                    atualizaMedia(Globais.listaAlunos, vetorDisciplina[i]);
                } else if (i == 0) {
                    limpaTelaMedia();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void limpaTelaMedia() {
        lvDisciplinaM = findViewById(R.id.lvDisciplinaM);
        lvDisciplinaM.setAdapter(new NotaAdapter(this, new ArrayList<>()));
    }


    private void atualizaMedia(ArrayList<Aluno> listaAlunos, String s) {
        String linha = "";
        String linha1 = "";
        String nota1bimestre = "";
        String nota2bimestre = "";
        String nota3bimestre = "";
        String nota4bimestre = "";
        ArrayList<String> alunoRa = new ArrayList<>();
        ArrayList<String> lista = new ArrayList<>();
        boolean fim = false;
        if(Globais.listaAlunos != null){
            for(Aluno aluno : Globais.listaAlunos){
                for(Bimestre nota : aluno.getNotasBimestre()){
                    for(String ra : alunoRa){
                        if(aluno.getRa() == ra){
                            fim = true;
                        }
                    }
                    if (nota.getDisciplina().equals(s)){
                        if(nota.getBimestre().equals("1º Bimestre")){
                            nota1bimestre = nota.getNota().toString();
                        }else if(nota.getBimestre().equals("2º Bimestre")){
                            nota2bimestre = nota.getNota().toString();
                        }else if(nota.getBimestre().equals("3º Bimestre")){
                            nota3bimestre = nota.getNota().toString();
                        }else if(nota.getBimestre().equals("4º Bimestre")){
                            nota4bimestre = nota.getNota().toString();
                        }
                    }
                }
                Double media = (Double.parseDouble(nota1bimestre) +
                        Double.parseDouble(nota2bimestre) +
                        Double.parseDouble(nota3bimestre) +
                        Double.parseDouble(nota4bimestre))/4;

                linha = (aluno.getRa() + "       ").substring(0, 29) + "MÉDIA: " + media;
                linha1 = (aluno.getNome() +"       ").substring(0, 29)+ (media >= 60 ? "APROVADO" : "REPROVADO");
                nota1bimestre = "";
                nota2bimestre = "";
                nota3bimestre = "";
                nota4bimestre = "";
                lista.add(linha + "\n" + linha1);
            }
        }
        lvDisciplinaM = findViewById(R.id.lvDisciplinaM);
        lvDisciplinaM.setAdapter(new MediaAdapter(this, lista));
    }


}