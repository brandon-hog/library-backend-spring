import { createBrowserRouter } from "react-router-dom";
import HomePage from "./routes/home";
import RegisterPage from "./routes/register";
import LoginPage from "./routes/login";

export const router = createBrowserRouter([
  {
    path: "/",
    Component: HomePage,
  },
  {
    path: "/register",
    Component: RegisterPage
  },
  {
    path: "/login",
    Component: LoginPage
  },
]);