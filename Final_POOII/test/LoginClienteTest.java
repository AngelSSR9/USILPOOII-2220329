import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import login.LoginCliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginClienteTest {
    
    private LoginCliente loginCliente;
    
    public LoginClienteTest() {
    }
    
    @Before
    public void setUp() {
        loginCliente = new LoginCliente();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testLoginBtnTxtMouseClicked() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        // Simulamos un evento de clic en el botón de inicio de sesión
        MouseEvent mouseEvent = new MouseEvent(
                loginCliente.loginBtnTxt,
                MouseEvent.MOUSE_CLICKED,
                System.currentTimeMillis(),
                0,
                0,
                0,
                1,
                false
        );

        // Utilizamos reflexión para acceder al método privado
        Method method = LoginCliente.class
                .getDeclaredMethod("loginBtnTxtMouseClicked", MouseEvent.class);
        method.setAccessible(true);
        
        
        loginCliente.dniTxt.setText("12345678");
        //Establecemos una contraseña incorrecta
        //Contraseña correcta: Angel12345
        loginCliente.passTxt.setText("Angel00000");
        
        //Invocamos al método
        method.invoke(loginCliente, mouseEvent);
        
        //Verificamos que NO se muestra el siguiente Frame luego de que el inicio de sesion falle
        assertFalse(loginCliente.menuPrincipal.isVisible());
    }

}
