package br.com.reflection;

import br.com.reflection.refl.Transformator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
public class TransformatorTest {

    Pessoa pessoa = new Pessoa(1, "Wallyson", 22);
    Endereco endereco= new Endereco("Rua 10", 20);

    @Test
    public void shouldTransform() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Transformator transformator = new Transformator();
        PessoaDTO pessoaDTO = transformator.transform(pessoa);

        Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTO);
        Assertions.assertEquals(pessoa.getNome(), pessoaDTO.getNome());
        Assertions.assertEquals(pessoa.getIdade(), pessoaDTO.getIdade());
    }

    @Test
    public void shoudNotTransform() {
        Assertions.assertThrows(ClassNotFoundException.class, () -> {
            Transformator transformator = new Transformator();
            transformator.transform(endereco);
        });
    }

    @Test
    public void shouldTransformWhenSomeFieldIsNull() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Pessoa pessoa1 = new Pessoa("João");
        Transformator transformator = new Transformator();
        PessoaDTO pessoaDTOSemCpf = transformator.transform(pessoa1);

        Assertions.assertEquals(pessoa1.getNome(), pessoaDTOSemCpf.getNome());
        Assertions.assertNull(pessoa1.getIdade());
    }
}
