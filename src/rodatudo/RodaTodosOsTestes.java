package rodatudo;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({"parte01.testes", "parte02.testes", "parte03.testes"})
public class RodaTodosOsTestes {

}
