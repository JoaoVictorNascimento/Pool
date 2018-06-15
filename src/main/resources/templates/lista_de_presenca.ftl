<!DOCTYPE html>
<html>
    <#include "layout.ftl">

<#macro page_body>
<h1> Lista de Presença </h1>

    <table>
        <tr>
            <th>Nome</th>
            <th>Presença</th>
        </tr>
         <#list presentes>

             <#items as presente>
            <tr>
                <td>${presente.name}</td>
                <td>
                    <label class = "check"><p>Presente</p>
                        <input type="checkbox">
                        <span class="checkmark"></span>
                    </label>
                </td>
            </tr>
             </#items>
         </#list>
    </table>

    <br>

    <div class align="center">
        <input class="square_btn" type="submit" value="Salvar">
    </div>
</#macro>
</html>

