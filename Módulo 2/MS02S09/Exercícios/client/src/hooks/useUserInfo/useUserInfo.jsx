import { useGlobalState, useSetGlobalState } from "../useGlobalState";

export function useUserInfo() {
  const globalState = useGlobalState();
  return globalState?.user;
}

export function useUserIsAdmin() {
  const user = useUserInfo();
  return user?.isAdmin;
}

export function useSetUserInfo() {
  const setGlobalState = useSetGlobalState();
  return (userInfo) => {
    setGlobalState((currentState) => {
      return { ...currentState, user: userInfo };
    });
  };
}
