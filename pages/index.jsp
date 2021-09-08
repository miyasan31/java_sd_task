<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  response.setContentType("text/html; charset=UTF-8");
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
    <div class="flex flex-col w-full h-screen">
      <header class="w-full bg-blue-400 py-4 border-b border-gray-200">
        <h1 class="text-center text-4xl font-bold text-white">
          カラオケシステム
        </h1>
      </header>
      <div class="flex flex-1 w-full bg-gray-100">
        <nav class="w-1/5 border-r border-gray-200">
          <div class="flex flex-col gap-2 p-4">
            <a
              href="/SD/pages/index.jsp"
              class="py-2 px-6 bg-blue-200 hover:bg-blue-100 font-bold rounded-full"
            >
              ホーム
            </a>
            <a
              href="/SD/pages/shift_join.jsp"
              class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
            >
              出勤登録
            </a>
            <a
              href="/SD/pages/shift_leaving.jsp"
              class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
            >
              退勤登録
            </a>
            <a
              href="/SD/pages/employee_insert.html"
              class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
            >
              従業員登録
            </a>
            <a
              href="/SD/pages/signin.html"
              class="py-2 px-6 hover:bg-blue-100 font-bold rounded-full"
            >
              ログアウト
            </a>
          </div>
        </nav>
        <main class="w-4/5">
        </main>
      </div>
    </div>
  </body>
</html>
