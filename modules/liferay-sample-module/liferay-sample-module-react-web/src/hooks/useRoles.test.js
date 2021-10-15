import '@testing-library/jest-dom';

import { useRoles } from "./useRoles";

describe('useRoles', () =>{
    it("should return all values false when variables aren't available", () => {
        
        const { isAdmin, isUser, isSignedIn } = useRoles()

        expect(isAdmin).toBeFalsy()
        expect(isUser).toBeFalsy()
        expect(isSignedIn).toBeFalsy()
    }); 


    it("should return all values true when variables are available", () => {
        global.SampleWorkspace = { isAdmin: true, isUser: true  }
        global.Liferay = {
            ThemeDisplay: {
                isSignedIn: () => true
            }
        }

        const { isAdmin, isUser, isSignedIn } = useRoles()

        expect(isAdmin).toBeTruthy()
        expect(isUser).toBeTruthy()
        expect(isSignedIn).toBeTruthy()
    }); 
 
})
