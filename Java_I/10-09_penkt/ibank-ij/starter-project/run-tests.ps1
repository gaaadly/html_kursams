# For a project without Maven. Run from any directory with PowerShell and JDK 21+.
$ErrorActionPreference = 'Stop'
$projectRoot = $PSScriptRoot
$classes = Join-Path $projectRoot 'target/manual-classes'
New-Item -ItemType Directory -Path $classes -Force | Out-Null
$taskJar = Join-Path $projectRoot 'lib/IBank.jar'
$runner = Join-Path $projectRoot '../lib/junit-platform-console-standalone-6.1.3.jar'
$classpath = $taskJar + [IO.Path]::PathSeparator + $runner
$sources = @(Get-ChildItem -LiteralPath (Join-Path $projectRoot 'src') -Recurse -Filter '*.java' | ForEach-Object FullName)
& javac --release 21 -encoding UTF-8 -cp $classpath -d $classes @sources
if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }
& java -jar $runner execute --class-path ($classes + [IO.Path]::PathSeparator + $taskJar) --select-class student.BankTest --fail-if-no-tests --disable-banner
exit $LASTEXITCODE
