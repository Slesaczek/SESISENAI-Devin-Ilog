import "./PageWrapper.css";

function PageWrapper({ children }) {
  return <main className="pageWrapperContainer">{children}</main>;
}

export default PageWrapper;
