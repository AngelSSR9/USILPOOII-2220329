
import conexionBD.ClienteDAO;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import login.RegisterCliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegisterClienteTest {
    private ClienteDAO clienteDAO;
    private RegisterCliente registerCliente;

    public RegisterClienteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        clienteDAO = new ClienteDAO();
        registerCliente = new RegisterCliente();
        //Establecemos valores a los campos de registrar con el campo de DNI incorrecto
        //ya que se necesitan 8 digitos para poder registrar a un cliente
        registerCliente.correoTxt.setText("angel@gmail.com");
        registerCliente.dniTxt.setText("1234567");
        registerCliente.nombreTxt.setText("Angel");
        registerCliente.passTxt.setText("Angel123");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testRegisterButtonMouseClicked2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        // Simulamos un evento de clic en el botón de registrar cliente
        MouseEvent mouseEvent = new MouseEvent(
                registerCliente.registerBtnTxt,
                MouseEvent.MOUSE_CLICKED,
                System.currentTimeMillis(),
                0,
                0,
                0,
                1,
                false
        );
        Method method = RegisterCliente
                .class.getDeclaredMethod("registerBtnTxtMouseClicked", MouseEvent.class);
        method.setAccessible(true);
        method.invoke(registerCliente, mouseEvent);
        
        assertTrue(clienteDAO.obtenerClientePorDNI(1234567) == null);

    }

}
