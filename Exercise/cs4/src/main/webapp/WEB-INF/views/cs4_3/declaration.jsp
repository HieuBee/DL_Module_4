<%--
  Created by IntelliJ IDEA.
  User: Thu Nguyen
  Date: 6/20/2023
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="declaration">
    <h3 style="text-align: center">TỜ KHAI Y TẾ</h3>
    <h5 style="text-align: center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h5>
    <p style="color: red; text-align: center">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</p>
    <table>
        <tr>
            <td>Họ và tên:<span style="color: red">(*)</span></td>
        </tr>
        <tr>
            <td><form:input path="name"/></td>
        </tr>
    </table>
    <br>
        <%----%>
    <table>
        <tr>
            <td>Năm sinh:<span style="color: red">(*)</span></td>
            <td>Giới tính:<span style="color: red">(*)</span></td>
            <td>Quốc tịch:<span style="color: red">(*)</span></td>
        </tr>
        <tr>
            <td style="width: 20px"><form:input path="yearOfBirth" cssStyle="width: 70px;"/></td>
            <td><form:select path="sex" items="${sex}"/></td>
            <td><form:select path="nationality" items="${nationality}"/></td>
        </tr>
    </table>
    <br>
    <table>
        <tr>
            <td>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác:<span style="color: red">(*)</span></td>
        </tr>
        <tr>
            <td><form:input path="idCard"/></td>
        </tr>
    </table>
    <br>
    <table>
        <tr>
            <td>Thông tin đi lại:<span style="color: red">(*)</span></td>
        </tr>
        <tr>
            <td><form:checkboxes path="vehicle" items="${vehicle}"/></td>
        </tr>
    </table>
    <br>
    <table>
        <tr>
            <td>Số hiệu phương tiện:</td>
            <td>Số ghế:</td>
        </tr>
        <tr>
            <td><form:input path="vehicleNumber"/></td>
            <td><form:input path="seats"/></td>
        </tr>
    </table>
    <br>
    <table>
        <tr>
            <td>Ngày khởi hành:<span style="color: red">(*)</span></td>
            <td>Ngày kết thúc:<span style="color: red">(*)</span></td>
        </tr>
        <tr>
            <td><form:input type="date" path="startDay"/></td>
            <td><form:input type="date" path="endDay"/></td>
        </tr>
    </table>
    <br>
    <table>
        <tr>
            <td>Trong vòng 14 ngày qua, anh/chị có đến tỉnh/thành phố nhào?:<span style="color: red">(*)</span></td>
        </tr>
        <tr>
            <td><form:textarea path="description"/></td>
        </tr>
    </table>
    <br>
    <span>Địa chỉ liên lạc</span>
    <table>
        <tr>
            <td>Tỉnh / Thành:<span style="color: red">(*)</span></td>
            <td>Quận / Huyện:<span style="color: red">(*)</span></td>
            <td>Phường / Xã:<span style="color: red">(*)</span></td>
        </tr>
        <tr>
            <td><form:input path="province"/></td>
            <td><form:input path="district"/></td>
            <td><form:input path="wards"/></td>
        </tr>
    </table>
    <table>
        <tr>
            <td>Địa chỉ nơi ở:<span style="color: red">(*)</span></td>
        </tr>
        <tr>
            <td><form:input path="address"/></td>
        </tr>
    </table>
    <br>
    <table>
        <tr>
            <td>Điện thoại:<span style="color: red">(*)</span></td>
            <td>Email: </td>
        </tr>
        <tr>
            <td><form:input path="phone"/></td>
            <td><form:input path="email"/></td>
        </tr>
    </table>
    <br>
    <span>Trong vòng 14 ngày qua, anh/chị có thấy xuất hiện dấu hiện nào sau đây không?</span>
    <br>
    <table>
        <tr>
            <td>Triệu chứng:<span style="color: red">(*)</span></td>
        </tr>
        <tr>
            <td><form:checkboxes path="symptom" items="${symptom}"/></td>
        </tr>
    </table>
    <br>
    <table>
        <tr>
            <td>Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, anh/chị có?<span style="color: red">(*)</span></td>
        </tr>
        <tr>
            <td><form:checkboxes path="history" items="${history}"/></td>
        </tr>
    </table>
    <form:button>GỬI TỜ KHAI</form:button>
</form:form>
</body>
</html>
