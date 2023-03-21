import "./CourseFilter.css";

function CourseFilter() {
  return (
    <div className="courseFilterContainer">
      <input type="text" placeholder="Busque pelo nome do curso" />
      <button>Buscar</button>
    </div>
  );
}

export default CourseFilter;
