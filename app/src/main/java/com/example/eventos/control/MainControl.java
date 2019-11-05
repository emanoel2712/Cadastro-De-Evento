package com.example.eventos.control;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.FileUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.eventos.R;
import com.example.eventos.model.dao.EnderecoDao;
import com.example.eventos.model.dao.EventoDao;
import com.example.eventos.model.entidade.Endereco;
import com.example.eventos.model.entidade.Evento;
import com.example.eventos.util.Constantes;
import com.example.eventos.view.PesquisaEventoActivity;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;

import cz.msebera.android.httpclient.Header;

public class MainControl {

//    private static final String TAG = "MainActivity";
    private Activity activity;
    private EditText editNome;
    private EditText editData;
    private EditText editEstado;
    private EditText editCidade;
    private EditText editBairro;
    private EditText editLogradouro;
    private EditText editCep;
    private EditText editNumero;

    private EventoDao eventoDao;
    private EnderecoDao enderecoDao;
    private Evento event;
    private Endereco endereco;

    private Uri imagemSelecionada;
//    public static final int INPUT_FILE_REQUEST_CODE = 1;
//    private ProgressDialog progressDialog;
//    private ValueCallback<Uri[]> mFilePathCallback;
//    private String mCameraPhotoPath;

    public MainControl(Activity activity) {
        this.activity = activity;

//
//        evento = new Evento();
//        evento.setEndereco(new Endereco());

        eventoDao = new EventoDao(activity);
//        enderecoDao = new EnderecoDao(activity);

        initComponents();
    }

    private void initComponents() {
        editNome = activity.findViewById(R.id.editNome);
        editData = activity.findViewById(R.id.editData);
        editEstado = activity.findViewById(R.id.editEstado);
        editCidade = activity.findViewById(R.id.editCidade);
        editBairro = activity.findViewById(R.id.editBairro);
        editCep = activity.findViewById(R.id.editCep);
        editLogradouro = activity.findViewById(R.id.editLogradouro);
        editNumero = activity.findViewById(R.id.editNumero);


    }

    public void cadastroPostEvento() {
        Evento evento = new Evento();



        evento.setNome(editNome.getText().toString());
        evento.setData(editData.getText().toString());
//            evento.setEndereco(new Endereco());
        evento.getEndereco().setEstado(editEstado.getText().toString());
        evento.getEndereco().setCidade(editCidade.getText().toString());
        evento.getEndereco().setBairro(editBairro.getText().toString());
        evento.getEndereco().setCep(editCep.getText().toString());
        evento.getEndereco().setLogradouro(editLogradouro.getText().toString());
        evento.getEndereco().setNumero(editNumero.getText().toString());

        Gson g = new Gson();

        RequestParams params = new RequestParams("params", g.toJson(evento));

        AsyncHttpClient client = new AsyncHttpClient();
        client.post("http://192.168.0.1:8080/GerenciarEvento/api/evento", params, new AsyncHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(activity, "Iniciando requisição", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onRetry(int retryNo) {
                super.onRetry(retryNo);
            }

            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                try {
                    eventoDao.getDao().create(event);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Toast.makeText(activity, "Sucesso na requisição", Toast.LENGTH_LONG).show();
//                limparCampos();
//                requisicaoPessoa();
//                atualizarListView();
//                pessoa = new Pessoa();
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(activity, "Erro na requisição", Toast.LENGTH_LONG).show();
            }
        });


    }



//    public void putFile(){
//        Uri file = Uri.fromFile(new File("path/to/images/rivers.jpg"));
//        StorageReference riversRef = storageRef.child("images/"+file.getLastPathSegment());
//        uploadTask = riversRef.putFile(file);
//
//// Register observers to listen for when the download is done or if it fails
//        uploadTask.addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                // Handle unsuccessful uploads
//            }
//        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
//                // ...
//            }
//        });
//
//    }

    public void carregarFoto() {
        Intent it = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        activity.startActivityForResult(Intent.createChooser(it, "Selecione uma imagem"), 123);


    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 123) {
                Uri imagemSelecionada = data.getData();
                String path = data.getData().getPath();

                }

            }

        }

        public void salvarAction () {
            Evento evento = new Evento();



            evento.setNome(editNome.getText().toString());
            evento.setData(editData.getText().toString());
//            evento.setEndereco(new Endereco());
            evento.getEndereco().setEstado(editEstado.getText().toString());
            evento.getEndereco().setCidade(editCidade.getText().toString());
            evento.getEndereco().setBairro(editBairro.getText().toString());
            evento.getEndereco().setCep(editCep.getText().toString());
            evento.getEndereco().setLogradouro(editLogradouro.getText().toString());
            evento.getEndereco().setNumero(editNumero.getText().toString());
//            e.getFoto().setCaminho(mFilePathCallback.toString());
//            e.getFoto().setCaminho(imagemSelecionada.toString());
//        listComanda.add(comanda);

            try {
                if (eventoDao.getDao().create(evento) > 0) {

                    Intent it = new Intent(activity, PesquisaEventoActivity.class);
                    it.putExtra(Constantes.PARAM_EVENTO, evento);
                    activity.startActivity(it);

//                    Intent it = new Intent(activity, PesquisaEventoActivity.class);
//                    activity.setResult(activity.RESULT_OK, it);
//                    activity.startActivity(it);
                }


            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }



