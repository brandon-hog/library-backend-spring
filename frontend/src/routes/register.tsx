import { Library } from "lucide-react"

import { SignupForm } from "@/components/signup-form"

export default function RegisterPage() {
  return (
    <div className="grid min-h-screen min-w-screen lg:grid-cols-2">
      <div className="flex flex-col gap-4 p-6 md:p-10">
        <div className="flex justify-center gap-2 md:justify-start">
          <a href="/" className="flex items-center gap-2 font-medium">
            <div className="bg-blue-600 p-2 rounded-lg">
              <Library className="text-white" size={24} />
            </div>
            LibStream
          </a>
        </div>
        <div className="flex flex-1 items-center justify-center">
          <div className="w-full max-w-xs">
            <SignupForm />
          </div>
        </div>
      </div>
      <div className="hidden lg:flex flex-col items-center justify-center relative bg-blue-600">
        <div className="text-5xl font-extrabold text-white">
          LibStream
          <div className="bg-black p-2 m-2 rounded-lg flex justify-center">
            <Library className="text-white" size={24} />
          </div>
        </div>
      </div>
    </div>
  )
}
