package hogwarts;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.MainPage;

import java.net.MalformedURLException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddMemberTest {
    private static MainPage main;

    @BeforeAll
    public static void AddMemberTest() throws MalformedURLException {
        main = new MainPage();
    }

    @ParameterizedTest
    @MethodSource("getMemberInfo")
    public void addMember(String name,String mobile){
        main.member().addMember(name,mobile);
        String text = main.member().getContactInfo();
        System.out.println("通讯录页面:" + text);
        assertTrue(text.contains("企业通讯录"));
    }

    public Stream<String> getMemberInfo(){
        return Stream.of("小天","13711122341");
    }
}
