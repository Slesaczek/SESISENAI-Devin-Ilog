import { createContext, useContext } from "react";

const UserInfoContext = createContext([]);

export default UserInfoContext;

export function useUserInfoContext() {
  return useContext(UserInfoContext);
}

export function useUserInfo() {
  const [value] = useUserInfoContext();
  return value;
}

export function useSetUserInfo() {
  const [value, setValue] = useUserInfoContext();
  return setValue;
}
