export function useRoles() {
    const isAdmin = SampleWorkspace.isAdmin || false
    const isUser = SampleWorkspace.isUser || false
    const isSignedIn = Liferay.ThemeDisplay.isSignedIn() || false
 
    return {
        isAdmin,
        isUser,
        isSignedIn
    }
}