package com.example.eventos.control;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import android.widget.EditText;
import android.widget.Toast;

import com.example.eventos.R;
import com.example.eventos.dao.EnderecoDao;
import com.example.eventos.dao.EventoDao;

import com.example.eventos.dao.FotoDao;
import com.example.eventos.model.entidade.Endereco;
import com.example.eventos.model.entidade.Evento;
import com.example.eventos.model.entidade.Foto;
import com.example.eventos.util.Constantes;
import com.example.eventos.view.PesquisaEventoActivity;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.SQLException;

import cz.msebera.android.httpclient.Header;

public class MainControl {
    private Activity activity;
    private EditText editNome;
    private EditText editData;
    private EditText editEstado;
    private EditText editCidade;
    private EditText editBairro;
    private EditText editLogradouro;
    private EditText editCep;
    private EditText editNumero;
    private EditText editFt;

    private EventoDao eventoDao;
    private EnderecoDao enderecoDao;
    private Evento evento;
    private Endereco endereco;
    private Foto foto;
    private FotoDao fotoDao;
    private Uri imagemSelecionada;
//    public static final int INPUT_FILE_REQUEST_CODE = 1;
//    private ProgressDialoandroid-async-http-1.4.9.jarg progressDialog;
//    private ValueCallback<Uri[]> mFilePathCallback;
//    private String mCameraPhotoPath;

    public MainControl(Activity activity) {
        this.activity = activity;

//        this.evento = new Evento();
//        this.endereco = new Endereco();
//        this.foto = new Foto();

        this.eventoDao = new EventoDao(activity);
        this.enderecoDao = new EnderecoDao(activity);
        this.fotoDao = new FotoDao(activity);

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
        editFt = activity.findViewById(R.id.editFT);

    }

//    public void cadastroPostEvento() {
//        Evento evento = new Evento();
//
//
//        evento.setNome(editNome.getText().toString());
//        evento.setData(editData.getText().toString());
//        evento.setEndereco(new Endereco());
//        evento.getEndereco().setEstado(editEstado.getText().toString());
//        evento.getEndereco().setCidade(editCidade.getText().toString());
//        evento.getEndereco().setBairro(editBairro.getText().toString());
//        evento.getEndereco().setCep(editCep.getText().toString());
//        evento.getEndereco().setLogradouro(editLogradouro.getText().toString());
//        evento.getEndereco().setNumero(editNumero.getText().toString());
//
//        Gson gson = new Gson();
//
//        RequestParams params = new RequestParams("params", gson.toJson(evento));
//
//        AsyncHttpClient client = new AsyncHttpClient();
//        client.post("http://192.168.0.21:8080/GerenciarEventoWebService/api/evento", params, new AsyncHttpResponseHandler() {
//
//            @Override
//            public void onStart() {
//                super.onStart();
//                Toast.makeText(activity, "Iniciando requisição", Toast.LENGTH_LONG).show();
//
//            }
//
//            @Override
//            public void onRetry(int retryNo) {
//                super.onRetry(retryNo);
//            }
//
//            @Override
//            public void onSuccess(int i, Header[] headers, byte[] bytes) {
//                try {
////                    eventoDao.getDao().create(event);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                Toast.makeText(activity, "Sucesso na requisição", Toast.LENGTH_LONG).show();
////                limparCampos();
////                evento = new Evento();
//            }
//
//            @Override
//            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
//                Toast.makeText(activity, "Erro na requisição", Toast.LENGTH_LONG).show();
//            }
//        });
//
//
//    }


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


    public void salvaFotof(File file) {




        String caminhoSalvarFoto = "C:\\Users\\USUARIO2\\AndroidStudioProjects\\Eventos\\app\\src\\main\\res\\drawable"
                + file.getName();

        String nomeFoto = file.getName();
        foto.setCaminho(nomeFoto);

        System.out.println("caminho da imagem salva é  = " + caminhoSalvarFoto);
    }




    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 123) {

                //acho q aqui pega o nome da foto ou os dados n sei
                Uri imagemSelecionada = data.getData();
//                String path = data.getData().getPath();

                String caminhoSalvarFoto = "C:\\Users\\USUARIO2\\AndroidStudioProjects\\Eventos\\app\\src\\main\\res\\drawable"
                        + imagemSelecionada;

                String nomeDaFoto = data.getDataString();



                Foto foto = new Foto();
                foto.setCaminho(nomeDaFoto);

            }

        }
    }

    private Evento getDadosForm() {
        Evento evento = new Evento();


        evento.setNome(editNome.getText().toString());
        evento.setData(editData.getText().toString());

        evento.getEndereco().setEstado(editEstado.getText().toString());
        evento.getEndereco().setCidade(editCidade.getText().toString());
        evento.getEndereco().setBairro(editBairro.getText().toString());
        evento.getEndereco().setCep(editCep.getText().toString());
        evento.getEndereco().setLogradouro(editLogradouro.getText().toString());
        evento.getEndereco().setNumero(editNumero.getText().toString());

//        Endereco e = new Endereco();
//
//        e.setEstado(editEstado.getText().toString());
//        e.setCidade(editCidade.getText().toString());
//        e.setBairro(editBairro.getText().toString());
//        e.setCep(editCep.getText().toString());
//        e.setLogradouro(editLogradouro.getText().toString());
//        e.setNumero(editNumero.getText().toString());

//        evento.setEndereco(e);

//        evento.setEndereco(e);

//        evento.setFoto(new Foto());
//        Foto foto = new Foto();
//        foto.setCaminho(editFt.getText().toString());
//        evento.setFoto(foto);
        evento.getFoto().setCaminho(editFt.getText().toString());


//            e.getFoto().setCaminho(mFilePathCallback.toString());
//            e.getFoto().setCaminho(imagemSelecionada.toString());
//        listComanda.add(comanda);
        return evento;
    }

    public void salvarEventoAction() {
        Evento e = getDadosForm();

        try {
//            if (eventoDao.getDao().createIfNotExists(e) > 0){
            if (eventoDao.getDao().create(e) > 0) {

                Intent it = new Intent(activity, PesquisaEventoActivity.class);
                it.putExtra(Constantes.PARAM_EVENTO, e);
                activity.startActivity(it);


//                    Intent it = new Intent(activity, PesquisaEventoActivity.class);
//                    activity.setResult(activity.RESULT_OK, it);
//                    activity.startActivity(it);*/
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}



