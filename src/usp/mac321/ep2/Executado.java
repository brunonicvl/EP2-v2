package usp.mac321.ep2;
import java.time.LocalDate;
import java.util.GregorianCalendar;


public class Executado implements EstadoLancamento {
    @Override
    public void setUser(Lancamento lancamento, Usuario u,LeitorFinancasPessoais leitor) {
        lancamento.user = u;
    }

     @Override
    public void setData(Lancamento lancamento, int dia, int mes, int ano, LeitorFinancasPessoais leitor) {
        if (dia <= 0 || mes <= 0 || ano <= 0) {
            lancamento.mudaEstado(new Invalido());
        } else {
            GregorianCalendar novaData = new GregorianCalendar(ano, mes - 1, dia);
            LocalDate dataAtual = LocalDate.now();

            LocalDate localDate = novaData.toZonedDateTime().toLocalDate();
            if (localDate.isBefore(dataAtual)) {
                lancamento.mudaEstado(new Executado());
            } else if (localDate.isAfter(dataAtual)) {
                lancamento.mudaEstado(new Planejado());
            }

            lancamento.data = novaData;
        }
    }

    @Override
    public void setTipo(Lancamento lancamento, TipoOperacao t, LeitorFinancasPessoais leitor) {
        
        lancamento.tipo = t;
    }

    @Override
    public void setValor(Lancamento lancamento, double valor, LeitorFinancasPessoais leitor) {
        if (valor < 0) {
            lancamento.mudaEstado(new Invalido());
        } else {
            lancamento.valor = valor;
        }
    }
}

