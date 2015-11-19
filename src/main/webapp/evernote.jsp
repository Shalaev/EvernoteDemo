<%--
  Created by IntelliJ IDEA.
  User: Sergey
  Date: 05.11.2015
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="ISO-8859-1" language="java" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <title>Evernote Demo</title>
    <meta equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value="/resources/evernote/css/style.css" />">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="<c:url value="/resources/evernote/js/script.js" />"></script>
</head>
<body>
 ${noteObj.noteText}
    <main>
        <div class="l-wrapper">
            <s:form class="b-form" method="post" commandName="noteForm" action="/evernote/" accept-charset="UTF-8" >
                <h1 class="b-form__title" >Evernote demo</h1>
                <hr>
                <s:hidden path="action" />
                <s:hidden path="shortMode"/>
                <table class="b-form__table">
                    <tr class="b-form__row">
                        <td class="b-form__column b-form__mode_control">
                            <s:input class="b-form__input" path="newNote" placeholder="Add new note" />
                        </td>
                        <td class="b-form__column b-form__mode_control">
                            <input class="b-form__button" type="button" onclick="Evernote.submitForm(this); return false;" value="Add">
                        </td>
                    </tr>
                    <c:forEach items="${noteForm.notes}" var="item" varStatus="teamsLoop">
                        <tr class="b-form__row">
                            <td class="b-form__column b-form__mode_note ${item.doneStatus eq 'true' ? 'b-form__status_done' : ''}" >
                                <s:hidden path="notes[${teamsLoop.index}].noteText"/>
                                <label for="${teamsLoop.index}" class="b-form__notetext">${item.noteText}</label>
                            </td>
                            <td class="b-form__column b-form__mode_note l-center">
                                <s:checkbox id="${teamsLoop.index}" path="notes[${teamsLoop.index}].checked"/>
                            </td>

                        </tr>
                    </c:forEach>
                    <tr class="b-form__row">
                        <td class="b-form__column b-form__mode_control">
                            <input class="b-form__button ${noteForm.shortMode eq 'All' ? 'b-form__button_select_short' : ''} " type="button" onclick="Evernote.submitShortForm(this); return false;" value="All">
                            <input class="b-form__button ${noteForm.shortMode eq 'Active' ? 'b-form__button_select_short' : ''} " type="button" onclick="Evernote.submitShortForm(this); return false;" value="Active">
                            <input class="b-form__button ${noteForm.shortMode eq 'Completed' ? 'b-form__button_select_short' : ''} " type="button" onclick="Evernote.submitShortForm(this); return false;" value="Completed">
                        </td>
                    </tr>
                    <tr class="b-form__row">
                        <td class="b-form__column b-form__mode_control">
                            <input class="b-form__button" type="button" onclick="Evernote.submitForm(this); return false;" value="Update">
                            <input class="b-form__button" type="button" onclick="Evernote.submitForm(this); return false;" value="Delete">
                        </td>
                    </tr>
                </table>
            </s:form>
        </div>
    </main>
</body>
</html>
