export function useRoles() {
    const isAdmin = SampleWorkspace.isAdmin || false
    const isUser = SampleWorkspace.isUser || false
    const isSignedIn = (typeof Liferay.ThemeDisplay === 'undefined') ? false :  Liferay.ThemeDisplay.isSignedIn() 
 
    return {
        isAdmin,
        isUser,
        isSignedIn
    }
}