<!DOCTYPE html>
<html>
<#include "layout.ftl">

<#macro page_body>
 <head>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
 </head>

<h1> Cadastro de Alunos</h1>
    <form name = "aluno" action = "add" method = "post">

        <div class="campo">
            <label for="nome">Nome</label>
            <input type="text" id="nome" name="nome" style="width: 25em" value="">
        </div>

        <div class="campo">
            <label for="rg">RG</label>
            <input type="text" name="rg" style="width: 15em" maxlength="9">
        </div>

        <div class="campo">
            <label for="cpf">CPF</label>
            <input type="text" name="cpf" style="width: 15em" maxlength="11">
        </div>

        <div class="campo">
            <label for="data">Data de Nascimento</label>
            <input type="date" id="data" name="data" min="1900-01-01">
        </div>

        <div class="campo">
            <label for="idade">Idade</label>
            <input type="number" id="idade" name="idade" min="0" max="150" style="width: 6em" value="">
        </div>

        <div class="campo">
            <label for="telefone">Telefone</label>
            <input type="text" id="telefone" name="telefone" style="width: 20em" value="">
        </div>

        <div class="campo">
            <label for="aula">Endereço</label>
            <input type="text" id="endereco" name="endereco" style="width: 40em" value="">
        </div>

        <div class="campo">
            <label for="modalidade">Modalidade</label>
            <input type="text" id="modalidade" name="modalidade" style="width: 20em" value="">
        </div>

        <div class="campo">
            <label for="aula">Aula</label>
            <input type="text" id="aula" name="aula" style="width: 20em" value="">
        </div>

        <br>

        <div class align="center">
            <input class="square_btn" type="submit" value="Cadastrar">
            <script>
                $( "#square_btn" ).click(function() {
                    $("#msg").html( "Handler for .click() called." );
                });
            </script>
        </div>

    </form>

</#macro>
