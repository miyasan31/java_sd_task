<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  response.setContentType("text/html; charset=UTF-8");
  String error =	request.getAttribute("error").toString(); 
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://cdn.jsdelivr.net/npm/tailwindcss@2.1/dist/tailwind.min.css"
      rel="stylesheet"
      type="text/css"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/daisyui@1.14.0/dist/full.css"
      rel="stylesheet"
      type="text/css"
    />
    <title>Document</title>
  </head>

  <body>
    <form action="/SD/servlet/signin" method="POST">
      <div
        class="
          flex flex-col
          justify-center
          items-center
          w-full
          h-screen
          bg-gray-100
        "
      >
        <h1
          class="
            text-center
            sm:text-3xl
            text-2xl
            font-medium
            title-font
            text-gray-800
            mb-4
          "
        >
          サインイン
        </h1>


        <div class="flex flex-col w-96 mx-auto gap-4">

          <div class="text-left text-red-400">メールアドレスまたはパスワードが間違っています</div>
          
          <div>
            <label for="email" class="leading-8 pl-2 text-gray-600">
              メールアドレス
            </label>
            <input
              type="text"
              id="email"
              name="EMPLOYEE_EMAIL"
              class="input input-info input-bordered w-full"
            />
          </div>

          <div>
            <label for="password" class="leading-8 pl-2 text-gray-600">
              パスワード
            </label>
            <input
              type="password"
              id="password"
              name="EMPLOYEE_PASSWORD"
              class="input input-info input-bordered w-full"
            />
          </div>

          <button
            class="
              w-full
              mx-auto
              text-white
              bg-blue-500
              border-0
              py-2
              px-8
              mt-2
              focus:outline-none
              hover:bg-blue-600
              text-lg
              rounded-full
            "
          >
            サインイン
          </button>
        </div>
      </div>
    </form>
  </body>
</html>
