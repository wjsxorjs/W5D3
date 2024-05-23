<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex3_Add</title>
<style>
    table caption{
        text-indent: -9999px;
    }
    #ip{
        background: rgb(230,230,230);
        border: none;
    }
</style>
</head>
<body>
    <div id="wrap">
        <header>
            <h1>부서추가</h1>
        </header>
        <article>
            <form action="Ex3_Add_Ok.jsp" method="post">
                <table>
                    <caption>부서추가테이블</caption>
                    <colgroup>
                        <col width="80px" />
                        <col width="*" />
                    </colgroup>
                    <tbody>
                        <tr>
                            <td>
                                <label for="deptno">부서코드</label>
                            </td>
                            <td>
                                <input type="text" name="deptno" id="deptno" />
                            </td> 
                        </tr>
                        <tr>
                            <td>
                                <label for="dname">부서명</label>
                            </td>
                            <td>
                                <input type="text" name="dname" id="dname" />
                            </td> 
                        </tr>
                        <tr>
                            <td>
                                <label for="loc">도시코드</label>
                            </td>
                            <td>
                                <input type="text" name="loc" id="loc" />
                                <!-- <input type="text" name="ip" id="ip"
                                readonly value = <%= request.getRemoteAddr()%> /> -->
                                
                            </td> 
                        </tr>
                        <tr>
                            <td colspan="2">
                                <button type="button" onclick="exe()">보내기</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </article>
    </div>

    <script>
        function exe(){
            document.forms[0].submit();
        }
    </script>
</body>
</html>