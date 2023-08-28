import org.example.model.Item;
import org.example.model.Pedido;
import org.junit.jupiter.api.*;

import java.sql.Array;
import java.util.ArrayList;

public class PedidoTeste {

    private static double expected;
    private static double result;
    private static double totalPedido;
    private static Item item;
    private static Item item2;
    private static Pedido pedido;
    private static ArrayList<Item> itens;

    @BeforeAll
    static void beforeAll(){
        item = new Item();
        item2 = new Item();
        itens = new ArrayList<>();
        pedido = new Pedido();
        totalPedido = 0;
    }

    @BeforeEach
    void setUp(){

        item.setVlUnit(1500.00);
        item.setId(1);
        item.setDescricao("Item 1");

        itens.add(item);

         pedido.setId(1);
        pedido.setItens(itens);

    }

    @Test
    void AdicionarItem() {
        expected = pedido.getItens().stream().count() + 1;

        pedido = pedido.adicionarPedido(pedido, item);

        Assertions.assertEquals(expected, pedido.getItens().stream().count());

    }

    @Test
    void RealizarPedido(){
        ArrayList<Item> lista = new ArrayList<>();

        pedido.setItens(lista);

        Assertions.assertEquals(0, pedido.getItens().size());
    }

    @Test
    void ValidarItem(){
        item.setDescricao("");

        ArrayList<Item> lista = new ArrayList<>();

        lista.add(item);

        pedido.setItens(lista);

        try{
            result = pedido.validaPedido(pedido);
        }catch (Exception ex){

        }
    }
    @Test
    void RemoverPedido(){
        ArrayList<Item> lista;

        lista = pedido.getItens();

        lista.remove(0);

        pedido.setItens(lista);

        Assertions.assertEquals(2, pedido.getItens().size());

    }

}
