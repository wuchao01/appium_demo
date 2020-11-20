package hogwarts;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
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
//    public void addMember(String name,String mobile){
    public void addMember(String name,String mobile,String updateName,String updateMobile){
        main.member().addMember(name,mobile).updateMember(updateName,updateMobile);
        String text = main.member().getContactInfo();
        System.out.println("通讯录页面:" + text);
        assertTrue(text.contains("企业通讯录"));
    }

    public static Stream getMemberInfo(){
        return Stream.of(
                Arguments.of("小天","13711122341"),
                Arguments.of("小超","13811122345"));
    }
}
