package br.com.reflection;

import br.com.reflection.refl.Transformator;

import java.lang.reflect.InvocationTargetException;

public class PessoaService {


    public PessoaDTO lits() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Pessoa pessoa = new PessoaRepository().lits();
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO = new Transformator().transform(pessoa);
        return pessoaDTO;

    }
}
