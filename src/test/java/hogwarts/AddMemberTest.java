package hogwarts;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;

import java.net.MalformedURLException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddMemberTest {
    private static MainPage main;

    @BeforeAll
    public static void AddMemberTest() throws MalformedURLException {
        main = new MainPage();
    }

    @ParameterizedTest
    @MethodSource("getMemberInfo")
    @Order(1)
//    public void addMember(String name,String mobile){
    public void addMemberTest(String name,String mobile){
        main.member().addMember(name,mobile);
        String text = main.member().getContactInfo();
        System.out.println("通讯录页面:" + text);
        assertTrue(text.contains("企业通讯录"));
    }

    @ParameterizedTest
    @MethodSource("updateMemberInfo")
    @Order(2)
    public void updateMember(String updateName,String updateMobile){
        main.member().updateMember(updateName,updateMobile);
    }

    @ParameterizedTest
    @ValueSource(strings = {"小天"})
    @Order(3)
    public void deleteMember(String deleteName){
        main.member().deleteMember(deleteName);
        String text = main.member().getContactInfo();
    }

    public static Stream getMemberInfo(){
        return Stream.of(
                Arguments.of("小天","13711122341"));
//                Arguments.of("小超","13811122345"));
    }

    public static Stream updateMemberInfo(){
        return Stream.of(
                Arguments.of("小超","13811122345"));
    }
}
