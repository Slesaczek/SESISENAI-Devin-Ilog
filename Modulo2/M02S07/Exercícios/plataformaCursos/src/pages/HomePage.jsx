import CourseFilter from "../components/CourseFilter";
import CourseList from "../components/CourseList";
import "./HomePage.css";

import reactJsImg from "../assets/reactjs.png";
import reactTsImg from "../assets/reactts.png";
import reactRouterImg from "../assets/reactrouter.png";
import contextApiImg from "../assets/contextapi.png";

const listaDeCursos = [
  {
    id: 635,
    imageUrl: reactJsImg,
    name: "React Js",
    category: "front-end",
    description: "Curso sobre React Js",
    duration: 6,
  },
  {
    id: 873,
    imageUrl: reactTsImg,
    name: "React com TS",
    category: "front-end",
    description: "Curso sobre React com TS",
    duration: 6,
  },
  {
    id: 935,
    imageUrl: reactRouterImg,
    name: "React Router",
    category: "front-end",
    description: "Curso sobre React Router",
    duration: 6,
  },
  {
    id: 333,
    imageUrl: contextApiImg,
    name: "Context API",
    category: "front-end",
    description: "Curso sobre Context API",
    duration: 6,
  },
  {
    id: 844,
    imageUrl: reactJsImg,
    name: "React Js",
    category: "front-end",
    description: "Curso sobre React Js",
    duration: 6,
  },
  {
    id: 287,
    imageUrl: reactTsImg,
    name: "React com TS",
    category: "front-end",
    description: "Curso sobre React com TS",
    duration: 6,
  },
  {
    id: 118,
    imageUrl: reactRouterImg,
    name: "React Router",
    category: "front-end",
    description: "Curso sobre React Router",
    duration: 6,
  },
  {
    id: 589,
    imageUrl: contextApiImg,
    name: "Context API",
    category: "front-end",
    description: "Curso sobre Context API",
    duration: 6,
  },
];

function HomePage() {
  return (
    <div className="homePageContainer">
      <CourseFilter />
      <CourseList list={listaDeCursos} />
    </div>
  );
}

export default HomePage;
