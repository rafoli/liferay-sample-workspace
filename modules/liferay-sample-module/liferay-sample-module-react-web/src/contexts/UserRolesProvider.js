import React, { createContext, useContext, useState, useEffect } from 'react'

const UserRolesContext = createContext({});

const UserRolesProvider = ({ children }) => {
    const [isAdmin, setIsAdmin] = useState(false)
    const [isUser, setIsUser] = useState(false)
    const [isSignedIn, setIsSignedIn] = useState(false)

    function loadUserRoles() {
        setIsAdmin(SampleWorkspace.isAdmin)
        setIsUser(SampleWorkspace.isUser)
        setIsSignedIn(Liferay.ThemeDisplay.isSignedIn())
    }

    useEffect(() => {
        loadUserRoles();
    }, []); 
    
    return (
        <UserRolesContext.Provider
            value={{ 
                isSignedIn,
                isAdmin,
                isUser
            }}
        >
            {children}
        </UserRolesContext.Provider>
    )
}

export const useRoles = () => useContext(UserRolesContext);

export default UserRolesProvider